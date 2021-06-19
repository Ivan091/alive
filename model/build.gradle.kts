plugins {
    id("by.alive.java-conventions")
}

dependencies {
    implementation("org.springframework:spring-beans:5.3.5")
    implementation("org.springframework:spring-core:5.3.5")
    implementation("org.springframework:spring-context:5.3.5")
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.4.4")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.1")
    testImplementation("org.mockito:mockito-core:3.8.0")
}

description = "model"
