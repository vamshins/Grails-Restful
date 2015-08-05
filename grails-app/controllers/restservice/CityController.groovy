package restservice

import grails.converters.JSON
import grails.converters.XML
//import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = false)
class CityController extends RestfulController {
    static responseFormats = ['json', 'xml']
//    static allowedMethods = [save: "POST", update: "PUT", patch: "PATCH", delete: "DELETE"]

    CityController() {
        super(City)
    }

    /*@Secured(['ROLE_USER'])
    def index() {
//        respond params.id ? City.get(params.id).categories : Category.list()
        respond params.id
    }*/
}
