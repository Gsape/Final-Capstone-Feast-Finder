<template>
  <div id="login" class="text-center">
    <section>
      <img id="logo" src="GitForkedLogo.png"/>
    </section>
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
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
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
            this.$router.push("/");
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

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Genos:ital,wght@1,100&display=swap');

#login {
  font-family: 'Genos', sans-serif;
  display: flex;
  justify-content: center;
  /* background-image: linear-gradient(to left, rgba(223, 117, 217, 0.603), rgba(125, 204, 224, 0.705)); */
  padding: 3rem;
  border-radius: 15px 50px 30px 5px;
  border-width: .5rem;
  margin-right: 60px;
  margin-left: 60px;
}

label {
  display: flex;
  font-size: 20px;
  font-weight: bold;
}

a {
  display: flex;
  justify-content: left;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

#backgroundimg {
  display: flex;
  justify-content: center;
  padding: 5rem;
  border-radius: 15px 50px 30px 5px;
  
}

#logo {
  width: 150px;
  height: auto;
 }

#backgroundimg2 {
  position: absolute;
  width: 100rem;
  padding: 200px;
  margin: -200px;
  left: 0px;
  top: 0px;
  z-index: -1;
}
</style>
