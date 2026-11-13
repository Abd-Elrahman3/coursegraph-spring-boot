# API Testing Primer

For MVC REST use MockMvc for slices and RestAssured or TestRestTemplate for real-server tests. For reactive HTTP/SSE use WebTestClient. For GraphQL use GraphQlTester; for gRPC use an in-process server for contracts plus a real transport test for deadlines/TLS. Mocked authentication in a slice must be supplemented with signature/issuer/audience tests.

Follow arrange → act → assert. Verify Location/ETag/Retry-After and problem codes as well as HTTP status. A 200 response with GraphQL errors is not successful business execution. Use generated random ports and disposable databases. Never assert only that the response is non-null.

Official references: https://docs.spring.io/spring-framework/reference/testing.html and https://rest-assured.io/.
