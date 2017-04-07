package com.agna.screen.generator.reader;

import com.agna.screen.generator.entity.ClassTemplate;
import com.agna.screen.generator.entity.FullConfiguration;
import com.agna.screen.generator.entity.GeneratorConfig;
import com.agna.screen.generator.reader.json.ClassTemplateObj;
import com.agna.screen.generator.reader.json.GeneratorConfigObj;
import com.google.gson.Gson;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximus on 05.02.2017.
 */
public class FullConfigurationReader {

    public static final String BASE_GENERATOR_CONFIG_FILE = "baseGeneratorConfig.txt";
    public static final String SCREEN_GENERATOR_CONFIG_FILE = "screenGeneratorConfig.txt";
    public static final String SCREEN_TEMPLATES_FOLDER = "screenTemplates";


    public FullConfiguration read(){
        Gson gson = new Gson();
        String baseGeneratorConfigString = sanitizeJson(ReaderHelper.readFile(BASE_GENERATOR_CONFIG_FILE));
        GeneratorConfig baseGeneratorConfig = gson.fromJson(baseGeneratorConfigString, GeneratorConfigObj.class).transform();

        String screenGeneratorConfigString = sanitizeJson(ReaderHelper.readFile(SCREEN_GENERATOR_CONFIG_FILE));
        GeneratorConfig screenGeneratorConfig = gson.fromJson(screenGeneratorConfigString, GeneratorConfigObj.class).transform();

        GeneratorConfig generatorConfig = baseGeneratorConfig.merge(screenGeneratorConfig);

        List<ClassTemplate> templates = new ArrayList<>();
        File[] templateFiles = new File(SCREEN_TEMPLATES_FOLDER).listFiles();
        if(templateFiles == null) {
            throw new IllegalStateException("template folder empty");
        }
        for (File templateFile : templateFiles) {
            if (templateFile.isFile()) {
                String classTemplateString = sanitizeJson(ReaderHelper.readFile(templateFile));
                ClassTemplate classTemplate = gson.fromJson(classTemplateString, ClassTemplateObj.class).transform();
                templates.add(classTemplate);
                System.out.printf("sanitized Class Template:\n"+ classTemplate.getCodeTemplate()+"\n");
            }
        }

        return new FullConfiguration(generatorConfig, templates);
    }

    private String sanitizeJson(String s) {
        String result = "";
        boolean isInsideLiteral = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            String textForAppend = String.valueOf(c);
            if(c == '"' && s.charAt(i-1) != '\\'){
                isInsideLiteral = !isInsideLiteral;
            } else if(c == '\n' && isInsideLiteral){
                textForAppend = "\\n";
            } else if (c == '\t'&& isInsideLiteral){
                textForAppend = "";
            }
            result += textForAppend;
        }
        System.out.printf(result);
        return result;
    }
}
