# Troubleshooting Notes

## Issue: `503 Service Unavailable` calling `rating-service`

### What happens

When starting the microservices, `user-service` sometimes fails with a `503` error when it tries to call `rating-service`:

```
Load balancer does not contain an instance for the service rating-service
```

### Why it happens

This is **not a bug** — it's a timing issue.

When `rating-service` starts up, it takes a little while to register itself with Eureka. Meanwhile, `user-service` is working off its own cached list of available services, which hasn't picked up the new registration yet. So even though `rating-service` is actually running, `user-service` doesn't know about it yet.

- Eureka clients refresh their local registry roughly every 30 seconds by default.
- Spring Cloud LoadBalancer also caches the resolved list of service instances for about 35 seconds on top of that.
- So it can take **up to 1–2 minutes** after a service starts before other services can reliably call it.

### How to fix / avoid it

1. **Start order** — start dependent services (`rating-service`, `hotel-service`, etc.) *before* `user-service`, so they've already registered by the time `user-service` needs them.
2. **Wait it out** — if you hit this error right after starting everything, just wait a minute or two and retry. It resolves itself once Eureka catches up.
3. **(Recommended) Add a fallback** — use a circuit breaker (e.g. Resilience4j) around the Feign calls so `user-service` degrades gracefully (e.g. returns the user with an empty ratings list) instead of throwing a 500 error whenever a downstream service is briefly unavailable.

### Quick check

To see what Eureka currently knows about, visit:

```
http://localhost:8761
```

Find your service name (e.g. `RATING-SERVICE`) in the list and confirm its status is `UP`.