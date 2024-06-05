plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	id("org.openapi.generator") version "7.6.0"
}

group = "aoleg.com.github"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	compileOnly("org.projectlombok:lombok:1.18.32")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}
openApiGenerate {
	generatorName.set("spring")
	inputSpec.set("$rootDir/src/main/resources/openapi.yaml")
	outputDir.set("$buildDir/generated")
	apiPackage.set("com.example.api")
	modelPackage.set("com.example.model")
	invokerPackage.set("com.example.invoker")
	configOptions = mapOf(
		"useSpringBoot3" to "true"
	)
}
sourceSets["main"].java.srcDir("$buildDir/generated/src/main/java")
