import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.SchemaOutputResolver;
import model.Aftale;
import model.AftaleListe;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;

import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AftaleXSDgen {
    public static void main(String[] args) throws JAXBException, IOException {
        AftaleListe aftaleliste = new AftaleListe();
        Aftale aftale = new Aftale();
        aftale.setCPR("1234567890");
        aftale.setTimeStart("2021-09-04 14:15:00");
        aftale.setTimeEnd("2021-09-04 14:30:00");
        aftale.setNotat("XSD Notat");
        aftale.setID("0");
        aftale.setKlinikID("0");

        aftaleliste.addAftaler(aftale);

        aftale = new Aftale();
        aftale.setCPR("1234567890");
        aftale.setTimeStart("2021-09-04 14:30:00");
        aftale.setTimeEnd("2021-09-04 14:45:00");
        aftale.setNotat("XSD Notat2");
        aftale.setID("0");
        aftale.setKlinikID("0");

        aftaleliste.addAftaler(aftale);

        JAXBContext jaxbContext = JAXBContext.newInstance(AftaleListe.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(aftaleliste,System.out);

        ArrayList<DOMResult> results = new ArrayList<DOMResult>();
        jaxbContext.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String ns, String file) throws IOException {
                DOMResult result = new DOMResult();
                result.setSystemId(file);
                results.add(result);
                return result;
            }
        });

        DOMResult result = results.get(0);
        System.out.println(result.toString());
        Document doc = (Document) result.getNode();
        System.out.println(doc);
        OutputFormat outputFormat = new OutputFormat(doc);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/model.AftaleListe.xsd"));
        XMLSerializer xmlSerializer = new XMLSerializer(fileOutputStream, outputFormat);
        xmlSerializer.serialize(doc);

    }
}

