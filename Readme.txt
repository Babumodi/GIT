session-service

A web service that maintains the session for the client.
For this to work, the client must use the property:
javax.xml.rpc.session.maintain
its value must be set to a true.

Uses: 

javax.xml.rpc.server.ServiceLifecycle
javax.xml.rpc.server.ServletEndpointContext



It can be verified that cookies are used to maintain the session for
the client by using the Client.java in utils project.
Just deploy the service and then run Client.java.


