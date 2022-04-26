import { serve, Handler } from "https://deno.land/std@0.135.0/http/server.ts";

class WebServer {
    private readonly handler: Handler

    constructor(handler: Handler) {
        this.handler = handler
    }

    async start() {
        await serve(this.handler, {
            hostname: "localhost",
            port: 80
        })
    }
}

export { WebServer }