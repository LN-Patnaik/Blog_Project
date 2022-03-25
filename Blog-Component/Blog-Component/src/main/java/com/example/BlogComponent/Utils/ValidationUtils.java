package com.example.BlogComponent.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtils {

    @Value("${list.bad.words}")
    List<String> badWords;

    public boolean validateBadWords(String comment) {
        String regexString = "^((?!.*(";
        for(int i=0;i<badWords.size();i++){
            regexString = regexString + badWords.get(i);
            if(!((badWords.size()-1) ==i)) {
                regexString = regexString + "|";
            }
        }
        regexString=regexString+").*).)*$";
        Pattern word = Pattern.compile(regexString);
        Matcher mat = word.matcher(comment);
        return mat.find();
    }
}
