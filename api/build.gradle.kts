plugins{
    id ("org.springframework.boot") version "2.5.4"
}


dependencies{
    implementation(project(":model"))
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("io.springfox:springfox-swagger-ui")
    implementation("io.springfox:springfox-boot-starter")
}