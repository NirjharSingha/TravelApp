<h1>TravelApp</h1>
This project presents the development of a Travel Planner web application designed to streamline the process of planning and managing travel. The application includes features such as user sign-in and sign-up, ticket booking, hotel reservations, landmark exploration, and comprehensive travel planning. Additionally, a "Contact Us" section allows users to communicate directly with the admin for support and inquiries. The platform enables general users to book services and offer their own, enhancing the overall travel experience. The application incorporates standard web functionalities to ensure a seamless user experience. Design patterns have been applied to ensure scalability, maintainability, and efficient operation of the system.

<h2>Tech-Stack Used in the Project:</h3> <br />
<b>Front-End Technology:</b>
<br />

- Next JS
- TailwindCSS
- Lottie Animations
- DaisyUI (UI Library)
- ShadCN (UI Library)

<br />
<b>Back-End Technology:</b>
<br />

- Spring Boot

<br />
<b>Database:</b>
<br />

- MySQL

<br />

<h2>Local Development:</h3> <br />

First clone the git repository using the following command.

```bash
git clone https://github.com/NirjharSingha/TravelApp.git
```

<b>Environment variables that need to update:</b>

<b>Client:</b>

| Variable Name                   | Value                                                                      |
|---------------------------------|----------------------------------------------------------------------------|
| NEXT_PUBLIC_SERVER_URL          | URL where spring boot server is running (By default http://localhost:8080) |
| NEXT_PUBLIC_CLIENT_URL          | URL where next js client is running (By default http://localhost:3000)     |
| NEXT_PUBLIC_OAUTH_CLIENT_ID     | Your OAUTH_CLIENT_ID                                                       |
| NEXT_PUBLIC_OAUTH_CLIENT_SECRET | Your OAUTH_CLIENT_SECRET                                                   |
| NEXT_PUBLIC_EMAILJS_SERVICE_ID  | Your EmailJS_Service_ID                                                    |
| NEXT_PUBLIC_EMAILJS_TEMPLATE_ID | Your EMAILJS_TEMPLATE_ID                                                   |
| NEXT_PUBLIC_EMAILJS_PUBLIC_KEY  | Your EMAILJS_PUBLIC_KEY                                                    |

<b>Server:</b>

| Variable Name                   | Value                                                                      |
|---------------------------------|----------------------------------------------------------------------------|
| SPRING_DATASOURCE_URL           | jdbc:mysql://localhost:3306/{Your_Database_Name}                           |
| SPRING_DATASOURCE_USERNAME      | Your database username (You can use "root" user)                           |
| SPRING_DATASOURCE_PASSWORD      | Password of the database user                                              |
| CLIENT_URL                      | URL where next js client is running (By default http://localhost:3000)     |
| JWT_SECRET                      | Your JWT_Secret_Key                                                        |
| STRIPE_SECRET_KEY               | Your STRIPE_SECRET_KEY                                                     |

<br/><br/>

At first let's build the client locally. Come to the base directory of the project and then create a .env file in the client folder (from base directory the path of the file is "./client/.env"). Then place the environment variables of the client section listed above with required values. Then from base directory, run the following commands in terminal.

```bash
cd client
npm install
npm run dev
```

This will start your react development server. To build your react client project, you can run this command:

```bash
npm run build
```

Now let's build the MySQL database locally. For this you must have MySQL installed in your local device. Then run the following command in terminal.

```bash
mysql -u root -p -e "CREATE DATABASE ${Your_Database_Name};"
```

This will create an empty database with only the entry of the Admin. The id and password of the Admin will be 'ADMIN' and 'pass' respectively. You can further modify this.

<br />
Now let's build the backend server locally. Come to the base directory of the project and then open the server folder. You can use an IDE <b>(INTELLIJ IDEA Recommended)</b> to run the server of your application. But you must have the <b>Lombok Plugin</b> installed in your <b>INTELLIJ IDEA</b> to run the spring boot server.

To set the environment variables for server open the application.yml (from base directory the path of the file is "./server/src/main/resources/application.yml") file and replace the environment variables of server section listed above with their corresponding values.

This will start your spring boot backend server.<br/>
Your backend server will be running on port 8080.

You can open your app on this link: 

http://localhost:3000

<br /><br />

<h2>Please Go Through The Documentation For Better Understanding</h2>
