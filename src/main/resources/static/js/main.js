// 'use strict';
//
// const serverPath = 'http://localhost:8080//themes/{id:\\d+?}';
//
// const getCurrentPage = () => {
//     const loc = (typeof window.location !== 'string') ? window.location.search : window.location;
//     const index = loc.indexOf('page=');
//     return index === -1 ? 1 : parseInt(loc[index + 3]) + 1;
// };
//
// const constructGetUrl = (url, queryParams) => {
//     for (let key in queryParams) {
//         if (queryParams.hasOwnProperty(key)) {
//             console.log(key, queryParams[key]);
//         }
//     }
// };
//
// (function loadAnswersPageable() {
//
//     const answerTemplate = (listItem) => {
//         const template = `<div class="card mb-3" style="max-width: 540px; align-content: center;">
//                     <div class="row g-0">
//                         <div class="col-md-4">
//                             <h4 class="img-fluid rounded-start">${listItem.user.name}</h4>
//                         </div>
//                         <div class="col-md-8">
//                             <div class="card-body">
//                                 <p class="card-text">${listItem.created}</p>
//                                 <p class="card-text">${listItem.description}</p>
//                             </div>
//                         </div>
//                     </div>
//                 </div>
//         `;
//
//         const elem = document.createElement('div');
//         elem.innerHTML = template.trim();
//         return elem.children[0];
//     };
//
//     const fetchAnswer = async (page, size) => {
//         const placesPath = `${serverPath}/themes?page=${page}&size=${size}`;
//         const data = await fetch(placesPath, {cache: 'no-cache'});
//         return data.json();
//     };
//
//     const loadNextAnswerGenerator = (loadNextElement, page) => {
//         return async (event) => {
//             event.preventDefault();
//             event.stopPropagation();
//
//             const defaultPageSize = loadNextElement.getAttribute('data-default-page-size');
//             const data = await fetchAnswer(page, defaultPageSize);
//
//             loadNextElement.hidden = data.length === 0;
//             if (data.length === 0) {
//                 return;
//             }
//
//             const list = document.getElementById('itemList');
//             for (let item of data) {
//                 list.append(answerTemplate(item));
//             }
//
//             loadNextElement.addEventListener('click', loadNextAnswerGenerator(loadNextElement, page + 1), {once: true});
//             window.scrollTo(0, document.body.scrollHeight);
//         };
//     };
//     document.getElementById('loadPrev').hidden = true;
//     const loadNextElement = document.getElementById('loadNext');
//     if (loadNextElement !== null) {
//         loadNextElement.innerText = "Load more";
//         loadNextElement.addEventListener('click', loadNextAnswerGenerator(loadNextElement, getCurrentPage()), {once: true});
//     }
//
// })();