package com.wideside.springvalidation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class DummyRestController {

    @GetMapping("/longCheck/{someValue}")
    public String longCheck(@PathVariable @Max(100L) Long someValue){
        return "il valore è " + someValue;
    }

    @GetMapping("/booleanCheck/{someValue}")
    public String booleanCheck(@PathVariable @NotNull Boolean someValue){
        return "il valore è " + someValue;
    }

    @GetMapping("/booleanCheckWithBody")
    public String booleanCheckWithBody(@RequestBody @Valid BooleanBody booleanBody){
        return "il valore è" + booleanBody.getBooleanValue();
    }
}
