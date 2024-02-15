package com.example.api.api;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class JsonController {

	@GetMapping("/json")
	public String findUser(@RequestParam(value = "name", defaultValue = "World") String name) {

        ObjectMapper mapper = new ObjectMapper();
        Student found = null;
        try {
            Student[] student = mapper.readValue(new File("src/main/data/users.json"), Student[].class);
            found=student[0];
        } catch (Exception e) {
            System.out.println(e);
        }

		return found.College;
	}
}