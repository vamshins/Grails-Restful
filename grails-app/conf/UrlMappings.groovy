class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        //
        // RESTService api
        "/api/city"(resources: 'city')
        "/api/customer"(resources: 'customer')
    }
}
