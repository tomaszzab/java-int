## Java Interview Problem

Application is run by default on 8080 port.
Entry point to list tickets:
Run ```curl -X GET http://localhost:8080/api/tickets```

## Issues:
1. UtilityService contains missing method. Implement according to javadoc.
2. TicketControllerTest not working. Fix it.
3. Client reports Invalid server error when trying to create periodic ticket. Verify problem and fix if needed. Client uses cmd:
```curl -H 'Content-type: application/json' -X POST http://localhost:8080/api/tickets -d '{"name":"Warsaw period ticket","state":"ACTIVE", "type":"PERIODIC"}' -i```
4. Transactional on update not working. Fix it.
5. Implement endpoint for filtering tickets by any combination of fields [name, state, type]. Endpoint is going to be used by web portal to manage users. 