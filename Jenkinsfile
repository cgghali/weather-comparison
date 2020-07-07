node{
    
      stage('Checkout source code from git'){
        git url: 'https://github.com/cgghali/weather-comparison.git', branch: 'master'
      }
      
      stage('Maven clean Package'){
          bat "mvn clean test"
  }
}