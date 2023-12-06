import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class StudentSerializer extends StdSerializer<Student> {

    protected StudentSerializer(Class<Student> t) {
        super(t);
    }

    @Override
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", student.getName());
        jsonGenerator.writeNumberField("age", student.getAge());
        jsonGenerator.writeEndObject();
    }
}
