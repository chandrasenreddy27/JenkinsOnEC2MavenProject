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
      if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' test"
          } 
          else {
            bat(/"${mvnHome}\bin\mvn" test/)
          }
      junit '**/target/surefire-reports/TEST-*.xml'
   }
   stage('Archive'){
      archive 'target/*.jar'
   }
   stage('SonarQube analysis') { 
      def scannerHome = tool 'MySonarQube_Scanner';
        withSonarQubeEnv('MySonarQube') { 
          sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=sonar-pipeline -Dsonar.sources=. "
        }
    }
   stage('Publish') {
        nexusPublisher nexusInstanceId: 'NexusLocal', nexusRepositoryId: 'releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/var/lib/jenkins/jobs/NewPipeLine/builds/lastSuccessfulBuild/archive/target/JankinsOnEC2Maven-4.0.0.jar']], mavenCoordinate: [artifactId: 'JankinsOnEC2Maven', groupId: 'pipeLine.chandrasen', packaging: 'jar', version: '4.0.0']]]
} 
}
