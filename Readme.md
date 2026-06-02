Client request
↓
Gateway receives request
↓
Your JwtValidation filter runs
↓
Calls auth-service (your WebClient)
↓
auth OK
↓
chain.filter(exchange)
↓
Spring continues pipeline
↓
LoadBalancer picks patient-service:41111
↓
Forward Filter sends HTTP request
↓
Patient Service receives request