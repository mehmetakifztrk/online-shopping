<div class="container">

	<div class="row">

		<!-- sidebar -->

		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- products -->

		<div class="col-md-9">

			<div class="row">

				<divclass"col-lg-12">
				
					<c:if test="${userClickAllProducts == true}">
						
						<script>
							window.categoryId = '';
						</script>
						
						<ol class="breadcrumb">
					
							<li href="${contextRoot}/home">Home</li>
							<li class="active">All Products</li>
						
						</ol>
						
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
						
						<script>
							window.categoryId = '${category.id}';
						</script>
						
						<ol class="breadcrumb">
					
							<li href="${contextRoot}/home">Home</li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						
						</ol>
						
					</c:if>
					
				</div>
			
			<div class="row">
				
				<div class="col-xs-12">
					
					<table id="productListTable" class="table table-stribled table-borderd">
					
						<thead>
						
							<tr>
							
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							
							</tr>
						
						</thead>
						
						<tfoot>
						
							<tr>
							
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							
							</tr>
						
						</tfoot>
					
					</table>
					
				</div>
				
			</div>
		
		</div>
		
	</div>

</div>
