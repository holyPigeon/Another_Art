import { createStore } from 'vuex'

const store = createStore({
  state() {
    return {
      // 메인페이지 현재 페이지
      currentPage: 1,
      sort: 'date',
      isArtRegistered: 0,
      // 회원가입
      registerData: {
        userId: '',
      },
      univName: '',
      // 로그인
      isLogined: false,
      loginUserId: 0,
      loginData: {
        userId: '0',
        userName:"초기값",
        userNickname:'초기값',
        loginId:'user0',
      },
      // 세션 정보
      sessionData: {
        // "id": 1,
        // "name": "빈센트 반 고흐",
        // "nickname": "고흐",
        // "loginId": "user1",
        // "loginPassword": "1234",
        // "email": "anotherart1@gmail.com",
        // "schoolName": "경기대학교",
        // "phoneNumber": "01011110000",
        // "address": "양양",
        // "birth": "2000-01-27"
      },
      // 검색 결과
      searchData: {
        contentSize: 0,
        artList: [
          {
            artLikeCount: 9,
            generalArt: {
              artId: 3,
              artName: "art3",
              artDescription: "이 작품은 작품입니다 - 3",
              artInitPrice: 10000,
              artRegisterDate: "2022-09-27 19:32:30",
              artStorageName: "6e0dc3f002.png",
              artOwnerId: 1,
              artOwnerNickname: "user1-Nickname",
              artOwnerSchoolName: "경기대학교"
            },
            artHashtagList: [
              "일상",
              "바다",
              "육아",
              "인스타",
              "타조"
            ]
          },
        ],
      },
      // 검색 유형
      searchType: 'auction',
      // 구매할 작품
        // 경매 작품
      selectedArt: {
        auctionArtBidCount: 13,
        auctionArt: {
          auctionId: 4,
          highestBidUserId: 24,
          highestBidUserNickname: "user24-Nickname",
          highestBidUserSchoolName: "고려대학교",
          highestBidPrice: 75000,
          auctionStartDate: "2022-09-26T00:00:00",
          auctionEndDate: "2022-09-28T00:00:00",
          artId: 5,
          artName: "art5",
          artDescription: "이 작품은 작품입니다 - 5",
          artInitPrice: 30000,
          artRegisterDate: "2022-07-10 09:00:03",
          artStorageName: "c53403583c.png",
          artOwnerId: 5,
          artOwnerNickname: "user5-Nickname",
          artOwnerSchoolName: "수원대학교"
        },
        artHashtagList: [
          "고양이",
          "반려견",
          "음식",
          "산",
          "삶",
          "게임",
          "개",
          "진돗개"
        ],
        // artLikeCount: 9,
        // generalArt: {
        //   artId: 3,
        //   artName: "art3",
        //   artDescription: "이 작품은 작품입니다 - 3",
        //   artInitPrice: 10000,
        //   artRegisterDate: "2022-09-27 19:32:30",
        //   artStorageName: "6e0dc3f002.png",
        //   artOwnerId: 1,
        //   artOwnerNickname: "user1-Nickname",
        //   artOwnerSchoolName: "경기대학교"
        // },
        // artHashtagList: [
        //   "일상",
        //   "바다",
        //   "육아",
        //   "인스타",
        //   "타조"
        // ],
      },
    }
  },
  mutations: {
    increment(state) {
      state.count++;
    },
    setIsLogined(state, payload) {
      state.isLogined = payload;
    },
    setSessionData(state, payload) {
      state.sessionData = {...payload};
    },
    setUnivName(state, payload) {
      state.univName = payload;
    },
    setSearchData(state, payload) {
      state.searchData.contentSize = JSON.parse(payload).contentSize;
      state.searchData.artList = [...JSON.parse(payload).artList];
    },
    setSearchType(state, payload) {
      state.searchType = payload;
    },
    setSelectedArt(state, payload) {
      state.selectedArt = { ...payload };
    },
    setCreateNum(state) {
      state.createNum++;
    },
    setCurrentPage(state, payload) {
      state.currentPage = payload;
    },
    setLoginUserId(state, payload) {
      state.loginUserId = payload;
    },
    setLoginData(state, payload) {
      state.loginData = payload;
    },
    setIsArtRegistered(state, payload) {
      state.isArtRegistered = payload;
    },
    setSort(state, payload) {
      state.sort = payload;
    },
  }
})

export default store;