import { WebServer } from "./webServer.ts"

const webServer = new WebServer(function (handler: Request): Response | Promise<Response> {
    //TODO: Handle Request
    return new Response(
        "",
        {
            status: 200
        }
    )
})

await webServer.start()