node{
    
      stage('Checkout source code from git'){
        git url: 'https://github.com/cgghali/ci-cd-demo.git', branch: 'master'
      }
      
      stage('Maven clean Package'){
          bat "mvn clean package"
  }
}