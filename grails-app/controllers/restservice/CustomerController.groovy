package restservice

import grails.rest.RestfulController

class CustomerController extends RestfulController {
    static responseFormats = ['json', 'xml']
    CustomerController() {
        super(Customer)
    }
}
