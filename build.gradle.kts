plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    java
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    repositories {
        mavenCentral()
    }
    dependencyManagement {
        imports {
            mavenBom("org.springframework:spring-framework-bom:5.3.5")
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.4.4")
        }
        dependencies {
            dependencySet("io.springfox:3.0.0") {
                entry("springfox-swagger-ui")
                entry("springfox-boot-starter")
            }
            dependencySet("com.fasterxml.jackson.core:2.12.4"){
                entry("jackson-annotations")
                entry("jackson-databind")
            }
        }
    }
    dependencies {
        testImplementation("org.mockito:mockito-core:3.11.2")
        testImplementation("org.mockito:mockito-junit-jupiter:3.11.2")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    }
}