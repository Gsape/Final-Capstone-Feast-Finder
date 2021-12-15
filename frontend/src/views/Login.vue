<template>
  <div id="login" class="text-center">
    <container class='login-image-container'>
      <img src="/heart-and-fork.png" class="logo" alt="logo">
    </container>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
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
      <span>
      <label for="username" class="sr-only"></label>
        <input type="text" id="username" class="form-control" placeholder="Username" v-model="user.username" required autofocus/>
      <label for="password" class="sr-only"></label>
      
        <input type="password" id="password" class="form-control px-3" placeholder="Password" v-model="user.password" required/>
      </span>
      <router-link id="Need_an_account" :to="{ name: 'register' }">Need an account?</router-link>
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
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

span {
  display: block;
  text-align: center;

}
#Need_an_account{
  display: block;
  text-align: center;
  padding: 10px;
}
#Sign_in{
  
  text-align: center;
  margin: auto;
  display: flex;
  
}

form{
  box-sizing: border-box;
  margin: 5px 200px 20px 200px;
  padding: 50px;
  box-shadow: 0 0 1rem 0 rgba(0, 0, 0, .2); 
  border-radius: 10px;
  background-color: rgba(255, 255, 255, .15);
  backdrop-filter: blur(5px);
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