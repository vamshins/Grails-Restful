package restservice

import grails.rest.RestfulController
import grails.transaction.Transactional
import groovy.time.TimeCategory
import org.codehaus.groovy.grails.web.servlet.HttpHeaders

import java.lang.invoke.MethodHandleImpl

import static org.springframework.http.HttpStatus.*
import grails.artefact.Artefact
import grails.util.GrailsNameUtils

import org.codehaus.groovy.grails.web.servlet.HttpHeaders
import org.springframework.http.HttpStatus

class CustomerController<T> extends RestfulController {
    static responseFormats = ['json', 'xml']
    CustomerController() {
        super(Customer)
    }

    /**
     * Updates a resource for the given id
     * @param id
     */
    @Transactional
    def update() {
        if(handleReadOnly()) {
            return
        }

        T instance = queryForResource(params.id)
        if (instance == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        instance.properties = getObjectToBind()

        if (instance.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond instance.errors, view:'edit' // STATUS CODE 422
            return
        }

        def map = instance.getProperties()

        map.each{ k, v -> println "${k}:${v}" }

        def dob = map.get('dob')
        def after1year
        use( TimeCategory ) {
            after1year = dob + 1.years
        }

        println after1year
        instance.putAt('dob', after1year)

        instance.save flush:true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: "${resourceClassName}.label".toString(), default: resourceClassName), instance.id])
                redirect instance
            }
            '*'{
                response.addHeader(HttpHeaders.LOCATION,
                        g.createLink(
                                resource: this.controllerName, action: 'show',id: instance.id, absolute: true,
                                namespace: hasProperty('namespace') ? this.namespace : null ))
                respond instance, [status: OK]
            }
        }
    }
}
