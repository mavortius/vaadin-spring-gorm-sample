package com.example

import com.example.init.BootStrap
import groovy.transform.CompileStatic
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@CompileStatic
@SpringBootApplication
class Application implements ApplicationRunner {

    private final BootStrap bootStrap

    Application(BootStrap bootStrap) {
        this.bootStrap = bootStrap
    }

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Override
    void run(ApplicationArguments args) throws Exception {
        bootStrap.init()
    }
}
