# Czerniakowskie-Lake
A project to illustrate, how to build software in Continuous Delivery manner.

### Name origin
This small project was named after a small lake that is situated in Warsaw. 
Even though this lake is small, it makes people leaving in Warsaw happy by making it possible to 
spend free time with family at a nice location and swim in open waters (for those, how like to swim :-) ).

### What this application does
This application helps children, that goes to elementary school, decide on what they should wear outside. 
Based on current weather information, the application provides advice on what kind of coat should be worn and if sunglasses should be taken or not. 

### Architecture
Even though this application is very small, it was build with hexagonal architecture in mind. 
It means, that there is a defined core of the application, and external 'connectors' are connected with usage of ports and adapters pattern.
The core of the application consists of the following parts:
#### Core
- `WeatherInformation` - a (**model**) class that represents current weather information
- `ClothingRecommendationService` - a (**service**)class with services implementing business rules on how a child should be dressed for outside based on weather information.

#### External connectors
- `IWeatherInformationClient` - interface representing port for adapters that provide weather information
- `ImgwWeartherInformationApiClient` - adapter implementation that uses IMGW REST service to obtain weather information.

### Some design decisions
This piece of software is intended to be used for educational purposes. Thus, the intention was to build into the application those concepts that are 
necessary to illustrate building automated tests with testing pyramid in mind and Continuous Delivery approach for delivering software. But intentionally, there are some 
simplifications, like there is no IoC container used nor any "big" framework, like Spring. There is only small framework used for REST API, called Javalin. 
The code itself was also build with simplicity and mind. 
