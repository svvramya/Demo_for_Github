package milestone;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Restassuredtest {
  @Test(priority = 1)
  public void getAllUsers() { 
	  given()
	    .log().all()
	  .when()
	    .get("/api/users?page=2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 2)
  public void createUser() {
	  String reqBody = "{\n"
	  		+ "    \"name\": \"morpheus\",\n"
	  		+ "    \"job\": \"leader\"\n"
	  		+ "}"; 
	  given()
	    .body(reqBody)
	    .log().all()
	  .when()
	    .post("/api/users/")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(201);
  }
  @Test(priority = 3)
  public void patchUser() { 
	  String reqBody = "{\n"
	  		+ "    \"name\": \"morpheus-updated\",\n"
	  		+ "}";
	  given()
	  .body(reqBody)
	    .log().all()
	  .when()
	    .patch("/api/users/2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 4)
  public void putUser() { 
	  String reqBody = "{\n"
	  		+ "    \"name\": \"morpheus\",\n"
	  		+ "    \"job\": \"zion resident\"\n"
	  		+ "}";
	  given()
	  .body(reqBody)
	    .log().all()
	  .when()
	    .put("/api/users/2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(200);
  }
  @Test(priority = 5)
  public void deleteUser() { 
	 
	  given()
	    .log().all()
	  .when()
	    .delete("/api/users/2")
	  .then()
	    .log().all()
	    .assertThat()
	    .statusCode(204);
  }
  
	@BeforeClass
	public void setUp() {
		baseURI = "https://reqres.in/";
	}
}