package io.apptik.json.modelgen;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.apptik.json.modelgen.util.UriUtils;
import io.apptik.json.modelgen.util.WordUtils;
import io.apptik.json.schema.Schema;
import io.apptik.json.schema.fetch.SchemaUriFetcher;

import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //Freemarker configuration object
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        try {
            cfg.setTemplateLoader(new FileTemplateLoader());
            //Load template from source folder
            Template template = cfg.getTemplate("model-generator/src/main/resources/JsonObject.ftl");
            Schema schema = new SchemaUriFetcher().fetch(URI.create("http://api.immoweb.be/rest/schema/error-r1"), null, null);

            System.out.println(schema);
            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            String schemaId = UriUtils.getSchemaId(schema.getOrigSrc());
            //TODO stop for now...
            data.put("schemaName", WordUtils.capitalize(WordUtils.underscore(schemaId)));

            data.put("properties", schema.getProperties().getEntries());
            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            // File output
            Writer file = new FileWriter(new File("/Users/sic/works/JustJson/model-generator/src/main/resources/Test.java"));
            template.process(data, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
