package restservice

import grails.converters.JSON
import grails.converters.XML
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = false)
class CityController extends RestfulController {
    static responseFormats = ['json', 'xml']
//    static allowedMethods = [save: "POST", update: "PUT", patch: "PATCH", delete: "DELETE"]

    CityController() {
        super(City)
    }

    /*def update = {
        def result
        def domain = invoke("save", params.id)
        if(domain) {
            domain.properties = params
            if(!domain.hasErrors() && domain.save()) {
                result = domain
            } else {
                result = new Error(message: "${domainClassName} could not be saved")
            }
        } else {
            result = new Error(message: "${domainClassName} not found with id ${params.id}")
        }
        format(result)
    }*/
}
