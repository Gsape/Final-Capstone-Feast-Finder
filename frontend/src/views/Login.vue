<template>
  <div id="login" class="text-center">
    <container class='login-image-container'>
    </container>
    <form class="form-signin" @submit.prevent="login">
      <h1 id='appname'>Welcome to Git Forked</h1>
      <h2 class="h3 mb-3 font-weight-normal">Sign in to Swipe</h2>
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
    <!-- <section>
      <img id="backgroundimg" src='https://media.istockphoto.com/photos/downtown-skyline-of-pittsburgh-pennsylvania-at-sunset-picture-id1047440036?b=1&k=20&m=1047440036&s=170667a&w=0&h=Qom8CzxTQHmXGjJET56GxTxU1kDmPX0xoxVq4hDL8Jc='/>
    </section> -->
      <section>
      <img id="backgroundimg2" src='https://images.unsplash.com/photo-1503197553955-b4eafae3e08e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1106&q=80'/>
    </section>
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
  margin: 100px;
  padding: 50px;
  box-shadow: 0 0 1rem 0 rgba(0, 0, 0, .2); 
  border-radius: 10px;
  background-color: rgba(255, 255, 255, .15);
  backdrop-filter: blur(5px);
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
