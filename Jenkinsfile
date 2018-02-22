node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/chandrasenreddy27/JenkinsOnEC2MavenProject.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -B -DskipTests clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -B -DskipTests clean package/)
      }
   }
   stage('Tests') {
      steps {
          sh 'mvn test'
       }
      post {
            always {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
   }
   stage('Archive'){
      archive 'target/*.jar'
   }
}
