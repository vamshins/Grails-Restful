
## Database:

```
CREATE TABLE customer(
  custid int not null,
  firstname Varchar(20),
  lastname Varchar(20),
  status varchar(10),
  gender varchar(1),
  dob date,
  emailid varchar(30),
  address varchar(100),
  phoneno varchar(10),
  password VARCHAR(32),
  CONSTRAINT pk_CUSTOMER PRIMARY KEY (custid)
);
```
```
Insert into customer values(10001,'Georgi','Facello','active','M','1953-09-02','gfacello@gmail.com','676 Little Cider Promenade, Spotted Horn, OH, 43979-0144, US','3956961242',MD5('Georgi'));
Insert into customer values(10002,'Bezalel','Simmel','active','F','1964-06-02','bsimmel@gmail.com','408 Stony Stead, Ben Hur, IN, 47675-1910, US','3817154227',MD5('Bezalel'));
Insert into customer values(10003,'Parto','Bamford','disabled','M','1959-12-03','pbamford@gmail.com','7892 Grand Crossing, Totstalahoeetska, DC, 20001-8376, US','8388337365',MD5('Parto'));
Insert into customer values(10004,'Chirstian','Koblick','active','M','1954-05-01','ckoblick@gmail.com','8935 Green Bear Loop, Big Shell, SC, 29875-0615, US','9985797517',MD5('Chirstian'));
Insert into customer values(10005,'Kyoichi','Maliniak','active','M','1955-01-21','kmaliniak@gmail.com','3885 Bright Villas, Stinking Creek, CA, 91303-2095, US','7754382127',MD5('Kyoichi'));
```

## Custom Restful Function
###Code to focus on:
#### CustomerController.groovy
- static allowedMethods = [updateYear: "PUT"]

- def updateYear()  (methods from customerService are called in this method)
```
  instance.putAt('dob', customerService.incrementYearByOne(instance))
```

#### CustomerService.groovy
- def customerService (CustomerService in services folder is injected here)
```
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
```


#### UrlMappings.groovy
```
	"/api/updatecustomeryear/$id"(action: "updateYear", controller: "customer", method: "PUT", parseRequest: true) {
            action = [PUT: "updateYear"]
        }
```

