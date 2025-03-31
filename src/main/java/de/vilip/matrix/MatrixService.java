package de.vilip.matrix;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.cosium.matrix_communication_client.MatrixResources;
import com.cosium.matrix_communication_client.Message;
import com.cosium.matrix_communication_client.RoomResource;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatrixService
{
	private final MatrixResources MATRIX_RESOURCES = createMatrixResources();

	@ConfigProperty(name = "de.vilip.matrix.hostname")
	String homeServer;

	@ConfigProperty(name = "de.vilip.matrix.username")
	String userName;

	@ConfigProperty(name = "de.vilip.matrix.password")
	String password;

	@ConfigProperty(name = "de.vilip.matrix.room-id")
	String roomId;

	public void sendMessage(String message)
	{
		RoomResource room = getRoom(MATRIX_RESOURCES);
		room.sendMessage(Message.builder().body(message).build());
	}

	private MatrixResources createMatrixResources()
	{
		return MatrixResources.factory()
			.builder()
			.https()
			.hostname(homeServer)
			.defaultPort()
			.usernamePassword(userName, password)
			.build();
	}

	private RoomResource getRoom(MatrixResources matrixResources)
	{
		return matrixResources.rooms().byId(roomId);
	}
}
