package com.agna.screen.generator.generator;

import com.agna.screen.generator.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maximus on 05.02.2017.
 */
public class Generator {
    
    public static final String PART_APPLYING_FORMAT = "[[%s]]";
    public static final String PART_APPLYING_FORMAT_REGEX = "\\[\\[%s\\]\\]";
    private static final String CLASS_PATH_TEMPLATE = "[[fullPathToFile]]";

    public List<ClassFile> generate(FullConfiguration fullConfiguration){
        return fullConfiguration.getClassTemplates().stream()
                .filter(classTemplate -> classTemplate.getConfig().correspondsTo(fullConfiguration.getGeneratorConfig().getConfig()))
                .map(classTemplate -> generateClass(classTemplate, fullConfiguration.getGeneratorConfig()))
                .collect(Collectors.toList());
    }

    private ClassFile generateClass(ClassTemplate classTemplate, GeneratorConfig generatorConfig) {
        System.out.printf("start generate Class: "+ classTemplate.getClassNameTemplate()+"\n");
        List<Part> allParts = new ArrayList<>();
        allParts.addAll(classTemplate.getParts());
        allParts.addAll(generatorConfig.getGlobalParts());

        String code = generateText(
                classTemplate.getCodeTemplate(),
                allParts,
                generatorConfig.getConfig(),
                generatorConfig.getParametersSets());
        String className = generateText(
                classTemplate.getClassNameTemplate(),
                allParts,
                generatorConfig.getConfig());
        String path = generateText(
                CLASS_PATH_TEMPLATE,
                allParts,
                generatorConfig.getConfig());

        System.out.printf("end generate Class: "+ classTemplate.getClassNameTemplate()+"\n");
        return new ClassFile(className, path, code);
    }

    private String generateText(String template, List<Part> contextParts, Config contextConfig){
        return generateText(template, contextParts, contextConfig, new ArrayList<>());
    }
    
    private String generateText(String template, List<Part> contextParts, Config contextConfig, List<ParametersSet> parametersSets) {
        String result = template;
        for(int i = 0; i < contextParts.size(); i++){
            Part part = contextParts.get(i);
            String partApplying = String.format(PART_APPLYING_FORMAT, part.getName());
            if(template.contains(partApplying)){
                String partValue = getPartValue(part, contextParts, contextConfig, parametersSets);
                result = result.replaceAll(String.format(PART_APPLYING_FORMAT_REGEX, part.getName()), partValue);
            }
        }
        return result;
    }

    private String getPartValue(Part part,  List<Part> contextParts, Config contextConfig, List<ParametersSet> parametersSets) {
        String value = "";
        if(part.isDependendsOnParameters()){
            ParametersSet parametersSet = parametersSets.stream()
                    .filter(set -> set.getName().equals(part.getParametersSetName()))
                    .findFirst()
                    .get(); //todo handle error
            ArrayList<Parameter> parameters = parametersSet.getParameters();
            for(int i = 0; i < parameters.size(); i++) {
                Parameter parameter = parameters.get(i);
                List<Part> newContextParts = PartListUtil.mergeParts(parameter.generateParameterParts(), contextParts);
                Config newContextConfig = contextConfig.merge(parameter.generateParameterConfig(i, parameters.size()));
                value += generateText(part.getSuitablePartValue(newContextConfig), newContextParts, newContextConfig, parametersSets);
            }
        } else {
            value = generateText(part.getSuitablePartValue(contextConfig), contextParts, contextConfig, parametersSets);
        }
        return value;
    }
}
