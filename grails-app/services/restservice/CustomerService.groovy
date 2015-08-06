package restservice

import grails.transaction.Transactional
import groovy.time.TimeCategory

@Transactional
class CustomerService<T> {

    def serviceMethod() {

    }

    def incrementYearByOne(T instance) {
        def map = instance.getProperties()

        map.each{ k, v -> println "${k}:${v}" }

        def dob = map.get('dob')
        def after1year
        use( TimeCategory ) {
            after1year = dob + 1.years
        }
        println "After incrementing, dob: " + after1year
        return after1year

    }
}
