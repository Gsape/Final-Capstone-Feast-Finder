<template>
  <div id="login" class="text-center">
    <container class='login-image-container'>
      <img src="/heart-and-fork.png" class="logo" alt="logo">
    </container>
    <form class="login" @submit.prevent="login" id="loginForm">
      <h1 id="welcome-message" class="h4 mb-4 text-center">Welcome to Feast Finder</h1>
      <h2 id="please-sign-in" class="h4 mb-4 text-center">Please Sign In</h2>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <span  class="input-fields">
      <label for="username" class="sr-only"></label>
        <input type="text" id="username" class="form-control mb-4" placeholder="Username" v-model="user.username" required autofocus/>
      <label for="password" class="sr-only"></label>
        <input type="password" id="password" class="form-control mb-4" placeholder="Password" v-model="user.password" required/>
      </span>
      <router-link id="Need_an_account" class="text-center" :to="{ name: 'register' }">Need an account?</router-link>
      <button id="Sign_in" type="submit">Sign in</button>
    </form>
    
  </div>
  
</template>
<script>
import authService from "../services/AuthService";
export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      // Accessing Database to Login
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");                                           // this takes us "home"
          }
        })
        .catch(error => {
          const response = error.response
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');
* {
    font-family: "OpenSans";
}

#welcome-message {
  font-size: 35px;
  font-family: 'Open Sans', sans-serif;
}


#please-sign-in {
  font-size: 25px;
}

span {
  font-weight: bold;
  display: block;
  text-align: center;
}
#Need_an_account{
  text-align: center;
  color: #000000;
  font-size: 20px;
  display: block;
  text-align: center;
  padding: 10px;
}
#Sign_in{
  margin: 20px;
  background-color: #6046ED;
  box-shadow: 0px 4px 8px 0px #F887D6;
  width: 180px;
  height: 50px;
  font-size: 20px;
  color:white;
  border-radius: 8px;
}

form {
  box-sizing: border-box;
  margin: 5px 200px 20px 200px;
  padding: 50px;
  box-shadow: 0 0 1rem 0 rgba(0, 0, 0, 0.308); 
  border-radius: 15px;
  background-color: rgba(167, 167, 167, 0.329);
  backdrop-filter: blur(15px);
  text-align: center;
}

.logo{
  height: 300px;
  width: auto;
}

#login-image {
  position: absolute;
  width: 100%;
  padding: auto;
  margin: auto;
  left: 0px;
  top: 0px;
  z-index: -1;
  object-fit: contain;
}
body {
	background: linear-gradient(-45deg, #faf883, #f781ae,#9c3aec, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
  font-family: "OpenSans";
}

@keyframes gradient {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}
</style>