This is prototype backend version for testing the microservice ..

## Request Flow (Microservice Architecture)

```
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
```


<img width="1080" height="931" alt="image" src="https://github.com/user-attachments/assets/67dfaa8b-eaae-4a20-a75b-945824b31344" />
