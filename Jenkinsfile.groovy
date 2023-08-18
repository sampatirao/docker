properties([

	parameters ([
		string (defaultValue: '', description: 'Enter the Docker Image Name', name: 'Image_name', trim: false),
	])
])


pipeline {
	agent {label 'main'}
	
	stages {
		stage('CLEAN WORKSPACE IN JENKINS SERVER'){
			steps {
				cleanWs()
			} // Steps Completed	
		}  // Stage Completed
	

		stage('CLONE THE SOURCE CODE FROM GIT-HUB'){
			steps {
				echo 'In SCM Stage'
				
				git credentialsId: 'git', url: 'https://github.com/hariharanjenkin/docker.git',branch: 'main'


			} // Steps Completed
		}  // Stage Completed	


		stage('Restarting Docker Service Status'){
			steps {
				
				sh'''
					systemctl start docker
					
				'''
			} // Steps Completed
		}  // Stage Completed

		stage('Verifiying the Dockerfile'){
			steps {
				
				sh'''
					echo 'Docker file verification'
					
					pwd
					ls

					cat Dockerfile
				'''
			} // Steps Completed
		}  // Stage Completed


		stage('Docker Build Image'){
			steps {
				
				sh'''
					echo 'Build Image'
					
					
				'''
			} // Steps Completed
		}  // Stage Completed

		stage('Image Creation Status'){
			steps {
				
				sh'''
									
					docker images
				'''
			} // Steps Completed
		}  // Stage Completed
	}
}
