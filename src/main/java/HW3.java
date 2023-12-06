import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;

public class HW3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student("John", 20, 3.6);
        try (FileOutputStream outFile = new FileOutputStream("student.ser"); ObjectOutputStream outStream = new ObjectOutputStream(outFile)) {
            outStream.writeObject(s);

        }

        SimpleModule module = new SimpleModule();
        module.addSerializer(Student.class, new StudentSerializer(Student.class));

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(module);
        xmlMapper.writeValue(new File("student.xml"), s);

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(module);
        jsonMapper.writeValue(new File("student.json"), s);

        Student s2, sJson, sXml;

        try (FileInputStream inFile = new FileInputStream("student.ser"); ObjectInputStream inStream = new ObjectInputStream(inFile)) {
            s2 = (Student) inStream.readObject();
        }
        System.out.printf("Unserialized student: %s\n", s2);

        sJson = new ObjectMapper().readValue(new File("student.json"), Student.class);
        System.out.printf("Unserialized from JSON: %s\n", sJson);

        sXml = new XmlMapper().readValue(new File("student.xml"), Student.class);
        System.out.printf("Unserialized from XML: %s\n", sXml);
    }

}
