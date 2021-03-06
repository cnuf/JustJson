package io.apptik.json.generator.generators;


import io.apptik.json.JsonElement;
import io.apptik.json.generator.Generator;
import io.apptik.json.generator.GeneratorConfig;
import io.apptik.json.schema.Schema;
import io.apptik.json.schema.SchemaList;

public class OneOfGenerator extends Generator {

    public OneOfGenerator(Schema schema, GeneratorConfig configuration) {
        super(schema, configuration);
    }

    public OneOfGenerator(Schema schema, GeneratorConfig configuration, String propertyName) {
        super(schema, configuration, propertyName);
    }

    @Override
    public JsonElement generate() {
        SchemaList list =  schema.getOneOf();
        Schema choice = list.get(rnd.nextInt(list.size()));
        return new Generator(choice, configuration).generate();
    }
}
