# Vehicle of Interest (VOI) Web Application

A read-only web application for law enforcement to view vehicle alert information including Silver Alerts, Amber Alerts, stolen vehicles, and arrest warrants.

## Features

- **Dashboard**: Overview statistics and recent updates
- **Vehicle Search**: Advanced filtering by license plate, make, model, color, year, and reason
- **Real-time Search**: Instant results as you type
- **Export Functionality**: Download vehicle data as CSV
- **Responsive Design**: Works on desktop and mobile devices
- **Demo Authentication**: Simple login for demonstration purposes

## Technology Stack

- **Backend**: Spring Boot 3.5.3 with Java 17
- **Database**: H2 in-memory database
- **Frontend**: HTML, CSS, JavaScript (Vanilla)
- **Security**: Spring Security (configured for demo mode)
- **Build Tool**: Maven

## Local Development

### Prerequisites
- Java 17 or higher
- Maven (or use included `mvnw` wrapper)

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Open your browser to `http://localhost:8080`
5. Login with any non-empty username and password

### Database Access
- H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:voiapp`
- Username: `sa`
- Password: (empty)

## Heroku Deployment

### Files for Heroku
- `Procfile`: Defines how to run the application
- `system.properties`: Specifies Java version

### Deployment Steps

1. Create a Heroku application:
   ```bash
   heroku create your-app-name
   ```

2. Deploy the code:
   ```bash
   git push heroku main
   ```

3. The application will be available at `https://your-app-name.herokuapp.com`

### Environment Variables
No additional configuration needed for basic deployment.

## Data

The application comes pre-loaded with 31 vehicle records including:
- 13 Silver Alerts
- 4 Amber Alerts  
- 9 Stolen Vehicles
- 5 Arrest Warrants

Data includes fictional characters from The Simpsons, Star Trek, Galaxy Quest, and Star Wars.

## API Endpoints

- `GET /api/vehicles` - Get all vehicles
- `GET /api/vehicles/{licensePlate}` - Get vehicle by license plate
- `GET /api/vehicles/search` - Search vehicles with filters
- `GET /api/vehicles/stats` - Get statistics
- `GET /api/vehicles/recent` - Get recent vehicles
- `GET /api/vehicles/reasons` - Get distinct reasons
- `GET /api/vehicles/makes` - Get distinct makes
- `GET /api/vehicles/colors` - Get distinct colors
- `GET /api/vehicles/years` - Get distinct years

## Security Note

This application is configured for demonstration purposes only. In production:
- Replace demo authentication with real authentication system
- Add proper user management and roles
- Implement HTTPS
- Add audit logging
- Configure proper database security

## Read-Only Design

This web application is designed as a read-only system. All data modifications should be handled by the separate desktop application. The web app only provides viewing and searching capabilities.

## Support

For technical issues or questions, contact your system administrator.
