<template>
  <div class="profile">
    <Navbar />

    <div class="background">
      <div class="overlay"></div>
      <div class="cover">
        <img  v-if="user.coverPhoto != null" :src="decodeImage(user.coverPhoto)" alt="" />
      </div>
    </div>
    <div class="container">
      <div class="profile-content">
        <div class="profile_photo">
          <div class="name">
            <div class="name_photo">
              <b-avatar :src="decodeImage(user.profilePhoto)"></b-avatar>
            </div>
            <div class="name_time">
              <div class="time">
                <span>{{ this.userName }}</span>
              </div>
              <h6 class="myname">
                <span>{{ fullname }}</span>
              </h6>
            </div>
          </div>
        </div>
        <div class="send_question">
          <div class="ask_yourself">
            <span>Ask yourself</span>
          </div>
          <div class="question_form">
            <textarea
              class="form-control"
              v-model="questionContent"
              aria-label="With textarea"
              placeholder="What,When,Why..Ask"
              rows="1"
            ></textarea>
          </div>
          <div class="question-buttons">
            <div class="content">
              <label class="switch">
                <input type="checkbox" v-model="checked" id="any" />
                <span class="slider round"></span>
              </label>
              <label for="any">Ask anonymously {{ checked }}</label>
            </div>
            <span class="send" @click="sendQuestion">Send</span>
          </div>
        </div>
        <div v-for="msg in messages" class="home_item" :key="msg.id">
          <div class="quetion"></div>
          <div class="send">
            <div class="anymo" v-if="msg.anoymos == false" @click="select(msg.askedUser)">
              <span>
                <b-avatar :src="decodeImage(msg.askedPhoto)" size="1.5rem"></b-avatar>
              </span>
              <span class="sender"> {{ msg.askedUser }}</span>
            </div>
            <h4>{{ msg.questionText }}</h4>
            <div class="name">
              <div class="name_photo">
                <b-avatar :src="decodeImage(msg.replies.answeredPhoto)"> </b-avatar>
              </div>
              <div class="name_time">
                <h6 class="myname">
                  <span> {{ msg.replies.userNameAnswered }}</span>
                </h6>
                <div class="time">
                  <span>{{ msg.replies.time }}</span>
                </div>
              </div>
            </div>

            <div class="answer">
              <span>{{ msg.replies.replyText }}</span>
            </div>
            <div class="like">
              <button class="btn btn-default" @click="toggleLike(msg)">
                <span
                  :class="[
                    msg.replies.likes.includes(userName) ? 'red' : 'grey',
                  ]"
                >
                  <i class="fa fa-heart" aria-hidden="true"></i>
                </span>
                {{ msg.replies.likes.length }}
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "../components/nbar.vue";

export default {
  name: "profile",
  data() {
    return {
      checked: true,
      questionContent: "",
    };
  },
  components: {
    Navbar,
  },
  methods: {
    toggleLike: function(msg) {
      if (msg.replies.likes.includes(this.userName)) {
          this.$store.dispatch("unlike",msg.stringID);
          msg.replies.likes.splice(msg.replies.likes.indexOf(this.userName));
      } else {
          this.$store.dispatch("like",msg.stringID);
          msg.replies.likes.push(this.userName);
      }
    },
    sendQuestion() {
      if (this.questionCharacterCount == 0) {
        alert("question is empty");
        return;
      }
      console.log("ggggggg");
      fetch(
        "http://localhost:5050/AddQuestion/" +
          this.session_userID +
          "/" +
          this.userName,
        {
          method: "post",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            askedUser: this.session_userName,
            anoymos: this.checked,
            text: this.questionContent,
          }),
        }
      );
    },
    select(userName) {
      this.$router.push({ name: "profile", params: { userName: userName } });
    },
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
  },
  computed: {
    session_userID() {
      return this.$store.state.userID;
    },
    session_userName() {
      return this.$store.state.userName;
    },
    userName() {
      // for this profile
      return this.$route.params.userName;
    },
    user() {
      return this.$store.state.profileData;
    },
    messages() {
      return this.$store.state.profileQuestions;
    },
    questionCharacterCount() {
      return this.questionContent.length;
    },
    fullname(){
      return this.user.firstName + " " + this.user.lastName
    }
  },
  created() {
    this.$store.commit('delete');
    this.$store.dispatch("loadProfileData", this.userName);
    this.$store.dispatch("loadProfileQuestions", this.userName);
  },
};
</script>
<style scoped>
.profile .cover {
  width: 100%;
  height: 55%;
  position: fixed;
  top: 60px;
  box-shadow: 100px 100px blur spread #000 inset;
}
.cover img {
  width: 100%;
  height: 100%;
}
.profile {
  background-color: #131619;
  height: 100000px;
}

.overlay {
  width: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  position: fixed;
  top: 60px;
  right: 0;
  left: 0;
  height: 55vh;
  z-index: 10;
  box-shadow: inset 0 -40px 50px 10px #131619;
}

.profile-content {
  position: relative;
  z-index: 11166;
}
.background {
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 10;
}
.home_item {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.container {
  width: 60%;
}
.sender {
  font-size: 13px;
}
.name {
  display: flex;
}
.name .name_photo,
.name .answer {
  margin: 5px;
}
.name .myname {
  margin-top: 6px;
  font-size: 90%;
}
.name_time {
  padding-left: 4px;
}
.name .time {
  font-size: 70%;
  margin-top: -7px;
  color: #b9b9bb;
}
.home_item .time {
  margin-top: -10px;
  font-size: 12px;
  color: #8f8f96;
  margin-bottom: 10px;
}
.like {
  margin-left: -10px;
  margin-top: 5px;
  font-size: 150%;
}
.btn span.grey {
  color: #cdcdd9;
}
.btn span.red {
  color: #ee4c22;
}
.like .btn {
  border: 0;
  font-size: 20px;
}
.profile_photo {
  padding: 40px 20px 50px;
}
.profile_photo .b-avatar {
  width: 6rem;
  height: 6rem;
  border: solid 4px rgba(117, 116, 116, 0.35);
}
.profile_photo .name_time {
  padding: 30px 20px;
  color: #fff;
  font-size: 120%;
}
.profile_photo .name .name_photo {
  cursor: pointer;
}
.profile_photo .time {
  color: #fff;
}
.send_question {
  background-color: #000;
  padding: 20px;
  margin: 20px;
  border-radius: 10px;
}
.question_form .form-control {
  border-radius: 7px;
  min-height: 20px;
  margin: 15px 0;
  padding: 10px;
}

.switch {
  position: relative;
  display: inline-block;
  width: 50px;
  height: 25px;
  margin-right: 10px;
}

.switch input {
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #6e6e6e;
  transition: 0.4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 18px;
  width: 18px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  transition: 0.4s;
}

input:checked + .slider {
  background-color: #e01144;
}

input:checked + .slider:before {
  transform: translateX(23px);
}

.slider.round {
  border-radius: 25px;
}

.slider.round:before {
  border-radius: 50%;
}
.question-buttons .content label {
  font-weight: 200;
}
.question-buttons .content label {
  font-size: 80%;
  color: #8f8f96;
}
.question-buttons .content label:hover {
  color: #fff;
  transition: 0.5s;
}

.question-buttons .content label {
  cursor: pointer;
}
.send_question .ask_yourself span {
  color: #fff;
}
.question-buttons {
  position: relative;
  padding-top: 10px;
}
.question-buttons .send {
  position: absolute;
  right: 0;
  bottom: 0;
  color: #fff;
  background-color: #e01144;
  padding: 7px 30px;
  cursor: pointer;
  border-radius: 4px;
}
</style>
