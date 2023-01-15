<%@ include file="../common/header.jsp" %>
<section class="h-full gradient-form bg-gray-200 md:h-screen">
	<div class="container py-12 px-6 h-full">
		<div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
			<div class="xl:w-10/12">
				<div class="block bg-white shadow-lg rounded-lg">
					<div class="lg:flex lg:flex-wrap g-0">
						<div
							class="lg:w-6/12 flex items-center lg:rounded-r-lg rounded-b-lg lg:rounded-bl-none"
							style="
								background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
							"
						>
							<img
								src="https://img.freepik.com/vecteurs-libre/illustration-concept-medecins_114360-1515.jpg?w=1380&t=st=1672504408~exp=1672505008~hmac=1d80e42c3e340220785ace211b856bc1735b26b3455998411d29048e819a2d0b"
								class="w-full h-full"
								alt="Signin image"
							/>
						</div>
						<div class="lg:w-6/12 px-4 md:px-0">
							<div class="md:p-12 md:mx-6">
								<div class="text-center">
									<h1 class="text-6xl text-red-600 font-semibold mt-1 mb-6 pb-1">
										Melefi
									</h1>
								</div>
								<form method="post">
									<h2 class="mb-4 text-3xl text-center">Connexion</h2>
									<h4 class="text-red-600 text-center font-bold mb-4">${statusMessage}</h4>
									<div class="mb-4">
										<input
											type="text"
											name="email"
											value="${user.email}"
											class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
											id="exampleFormControlInput1"
											placeholder="Email"
										/>
										<span class="text-red-600">${ errors.email}</span>
									</div>
									<div class="mb-4">
										<input
											type="password"
											name="password"
											class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
											id="exampleFormControlInput1"
											placeholder="Mot de passe"
										/>
										<span class="text-red-600">${ errors.password}</span>
									</div>
									<div class="text-center pt-1 mb-12 pb-1">
										<button
											class="inline-block px-6 py-2.5 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:shadow-lg focus:outline-none focus:ring-0 active:shadow-lg transition duration-150 ease-in-out w-full mb-3"
											type="submit"
											data-mdb-ripple="true"
											data-mdb-ripple-color="light"
											style="
												background: linear-gradient(
													to right, #ee7724, #d8363a, #dd3675, #b44593
												);
											"
										>
											Se connecter
										</button>
										<a class="text-gray-500" href="#!">
											Mot de passe oublie?
										</a>
									</div>
									<div class="flex items-center justify-between pb-6">
										<p class="mb-0 mr-2">Vous n'avez pas de compte?</p>
										<a
											href="${ pageContext.request.contextPath }/inscription"
											type="button"
											class="inline-block px-6 py-2 border-2 border-red-600 text-red-600 font-medium text-xs leading-tight uppercase rounded hover:bg-black hover:bg-opacity-5 focus:outline-none focus:ring-0 transition duration-150 ease-in-out"
											data-mdb-ripple="true"
											data-mdb-ripple-color="light"
										>
											Creer-en
										</a>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="../common/footer.jsp" %>