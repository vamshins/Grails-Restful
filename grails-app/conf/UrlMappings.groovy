class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
//            controller = "rest"
//            action = [GET:"show", PUT:"create", POST:"update", DELETE:"delete"]
//            action = [show:"GET", save: "POST", update: "PUT", patch: "PATCH", delete: "DELETE"]
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        //
        // RESTService api
        "/api/city"(resources: 'city')
        "/api/customer"(resources: 'customer')
        "/api/updatecustomeryear/$id"(action: "updateYear", controller: "customer", method: "PUT", parseRequest: true) {
            action = [PUT: "updateYear"]
        }
    }
}
