<template>
  <div id="login" class="text-center">
    <container class='login-image-container'>
    <img id='login-image' src="loginpagecopy.jpg"/>
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
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
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
.sr-only {
display: block;
text-align: center;
width:100%;
padding: 10px;

color: #313131;
font: 20px;

border-radius: 0px 16px 0px 16px;
}

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
  
  border: 2px solid rgb(66, 2, 66) ;
  border-block-style:solid ;
  border-bottom-width:medium ;
  box-sizing: border-box;
  margin: 200px;
  padding: 5px;
  
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





</style>