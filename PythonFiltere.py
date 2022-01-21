#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
For at køre python filteret så skal man ligge filen
ind i Person_1 EKG Måling

@author: bruger
"""
#importer Data og nøvendige bibliotekker
import matplotlib.pyplot as plt
import numpy as np
from scipy import signal
from scipy.signal import butter, filtfilt
import wfdb 

#attributter
Ts = 1/500 #Tidsperiode
Fs = 1/Ts #Samplefrekvensen
N = 2000 #Samplerate


t=np.arange(0,N*Ts,Ts)
#definere en arrag 

""" Baseline """
#vi har brugt både rec_12 og rec_6 fra person_1 
signals1, info = wfdb.rdsamp('rec_6', channels=[0, 1], 
                              sampfrom=0, sampto=N)

ecg0 = signals1[:,0] #ecg0 er rå EKG-data
ecg1 = signals1[:,1] # ecg1 er filteret ekg-Data


#Rå data plottes i tidsdomæne
plt.title('ECG rå med støj')
plt.xlabel('tid(s)')
plt.ylabel('Millivolts')
plt.plot(t,ecg0)
plt.show()


#Vi laver LPF til BW støj : (numptaps er længden af filteret)
filter = signal.firwin(numtaps = 301, fs = 500, cutoff = 0.667, pass_zero = False)
filtretsSignal = signal.filtfilt(filter,1,ecg0)
#plot i tidsdomæne
plt.plot(t,filtretsSignal)
plt.title('filteret for basislinje EKG')
plt.show()
#plot i frekvense domæne (rå data)
plt.magnitude_spectrum(ecg0,Fs=Fs)
plt.title('ECG rå med støj')
plt.show()

#plot i frekvense domæne (filteret data)
plt.magnitude_spectrum(filtretsSignal,Fs=Fs)
plt.title('filtreret for basislinje EKG')
plt.show()



""" Powerline interference """

""" Notch filter """



fs = 500  # Sample frequency (Hz)
f0 = 50  # Frequency to be removed from signal (Hz)
Q = 0.4166 # Quality factor
f1 = 0.667
Q1 = 0.1334


# Design notch filter til at fjerne baseline wander støj
b1, a1 = signal.iirnotch(f1, Q1, fs)
x = signal.freqz(b1, a1, fs=fs)
NotchFilter1 = signal.filtfilt(b1, a1, filtretsSignal)
#plotter notchFilter
plt.plot(NotchFilter1, color = 'red')
plt.plot(ecg0, color ='green')
plt.title('Grøn med & rød uden netstøj')
plt.xlabel('tid(s)')
plt.ylabel('Millivolts')
plt.show()


#Design notch filter til at fjerne powerline støj samt baseline støj
b2, a2 = signal.iirnotch(f0, Q, fs)
x = signal.freqz(b2, a2, fs=fs)
NotchFilter2 = signal.filtfilt(b2, a2, NotchFilter1)
#plotter notch Filter2
plt.plot(NotchFilter2)
plt.title('Notch filteret')
plt.show()

#plotter notch filter i frekvense domæne
plt.magnitude_spectrum(ecg0,Fs=Fs)
plt.title('Med støj i spektret')
plt.show()
plt.magnitude_spectrum(NotchFilter2,Fs=Fs)
plt.title('Notchfilteret')
plt.show()


"""EMG """

#Design moving average filter 
#h=np.array([1/8,1/8,1/8,1/8,1/8,1/8,1/8,1/8])

i=0
h=np.array(NotchFilter2[i:i+8])
AMFilter = signal.filtfilt(h, [1], NotchFilter2)

#plotter før ffilteret med MA-filter i TD
plt.plot(t,NotchFilter2)
plt.title('EMG støj i Tidsdomæne')
plt.xlabel('tid (s)')
plt.ylabel('mV')
plt.show()
#plotter efter filteret med MA-filter i TD
plt.plot(t,AMFilter)
plt.title('EMG støj filtreret i Tidsdomæne')
plt.xlabel('tid (s)')
plt.ylabel('mV')
plt.show()
#plotter før ffilteret med MA-filter i FD
plt.title('EMG støj filtreret i spektrum')
plt.magnitude_spectrum(NotchFilter2,Fs=Fs)
plt.show()
#plotter efter filteret med MA-filter i FD
plt.title('EMG støj filtreret i spektrum')
plt.magnitude_spectrum(AMFilter,Fs=Fs)
plt.show()

"""Python-Json"""
import requests
import json

""""Json """
#https://pynative.com/python-post-json-using-requests-library/
import requests
import json

#payload = json.dump(MovinAverageFilter.tolist())

#VVi har lavet en post requeste til at sende ecgData i intillij

headers={'Authorization':'Bearer hemmeliglogin','Identifier':'1123456789','Session':'8', 'Timestart':'YYYY:MM:DD:HH:MM'}


req= requests.post('http://ekg4.diplomportal.dk:8080/Semesterprojekt3_war/data/ekgSessions', json={"data": MovinAverageFilter.tolist()}, headers=headers)
print(req.text)

#Ved get requeste modtager vi ecgData fra intillij.
#req3= requests.get('http://ekg4.diplomportal.dk:8080/data/ekgSessions',headers=headers)
#print(req3.text)