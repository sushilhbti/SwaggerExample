package Demo.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/hello")
@Api(value = "Hello World Resource", description = "shows hello world")

@ApiResponses(
        value = {
                @ApiResponse(code = 100, message = "100 is the message"),
                @ApiResponse(code = 200, message = "Successful Hello World")
        }
)

public class HelloResource {

//    @ApiOperation(value = "Returns Hello World")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(code = 100, message = "100 is the message"),
//                    @ApiResponse(code = 300, message = "Successful Hello World")
//            }
//    )

    @ApiOperation(value = "Get Value Hello")
    @GetMapping // This is Get Message by Default use
    public String hello() {
        return "Hello World";
    }

    @ApiOperation(value = "Post Hello World")
    @PostMapping("/post")
    public String helloPost(@RequestBody final String hello) {
        return hello;
    }

    @ApiOperation(value = "Put Hello World")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello) {

        return hello;
    }


    @ApiOperation(value = "Delete Hello World")
    @DeleteMapping("/Delete")
    public  String helloDelete(@RequestBody final String  delete){
        return  delete;
    }
}
